package validator // можно использовать функционал этого пакета в другом файле

interface Validatable { // абстрактный клас


    /**
     * @throws [ValidationErrorException]
     */
    fun validate()// абстрактная функция
}



class ValidationErrorException(
        val errors: List<ValidationError>
) : Exception() {



    /***
     * Convenience method for getting a data object from the Exception.
     */
    fun toValidationErrors() = ValidationErrors(errors)
}



/**
 * Data object to represent the data of an Exception. Convenient for serialization.
 */
data class ValidationErrors(
        val errors : List<ValidationError>
)



data class ValidationError(
        val path: String,
        val message: String
)