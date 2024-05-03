# Formz [![](https://jitpack.io/v/kamrul3288/formz.svg)](https://jitpack.io/#kamrul3288/formz)
Meet Formz,  aims to simplify form representation and validation in a generic way.

![](https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExbTF1eW82OHVheHdlNTJiaHZ1bXBpdXhuazhwaWl4c25yOWM0NzkwdSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/Rutixd2qCmQwtWvweD/giphy.gif)

# How to
Step 1. Add the JitPack repository to your settings.gradle.kts build file.
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven{
            uri("https://jitpack.io")
        }
    }
}
```
Step 2. Add the dependency
```gradle
dependencies {
    implementation("com.github.kamrul3288:formz:1.0.2")
}
 ```
## Create a FormzInput
```kotlin
class EmailInput : FormzInput<String,String>(){
    override fun pure(): String = ""

    private val emailRegex = Regex("^[a-zA-Z\\d.!#\$%&’*+/=?^_`{|}~-]+@[a-zA-Z\\d-]+(?:\\.[a-zA-Z\\d-]+)*\$")

    override fun validator(value: String): String? {
        return when(emailRegex.matches(value)){
            true -> null
            false -> "Please enter valid email"
        }
    }
}
```

## Interact with a FormzInput
```kotlin
emailInput.dirty("example@gmail.com")
println(emailInput.value)
println(emailInput.isError())
println(emailInput.displayError())
println(emailInput.isValid())
```
## Validate Multiple FormzInput Items
```kotlin
val isFormsValid = FormZ.validate(listOf(emailInput,passwordInput))
println(isFormsValid)
```

## Android MDC Exampe
```xml
<com.google.android.material.textfield.TextInputLayout
    android:id="@+id/passwordTL"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="@string/hint_enter_password">

    <com.google.android.material.textfield.TextInputEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</com.google.android.material.textfield.TextInputLayout>
```
```kotlin
private val emailInput = EmailInput()
inding.emailTL.editText?.doAfterTextChanged {
    emailInput.dirty(it.toString())
    binding.emailTL.error = emailInput.displayError()
}
```
## Android Jetpack Compose Exampe
```kotlin
OutlinedTextField(
    modifier = Modifier.fillMaxWidth(),
    value = viewModel.emailInput.value,
    label = {
      Text(text = "Enter email")
    },
    onValueChange = viewModel::onChangeEmailInput,
    supportingText = {
        if (viewModel.emailInput.displayError() != null){
            Text(text = viewModel.emailInput.displayError()!!)
        }
    },
    isError = viewModel.emailInput.isError()
)
```
```kotlin
class LoginViewModel : ViewModel(){
    var emailInput by mutableStateOf(EmailInput(), neverEqualPolicy())
        private set

    fun onChangeEmailInput(value:String){
        emailInput  = emailInput
        emailInput.dirty(value)
    }
}
```





















