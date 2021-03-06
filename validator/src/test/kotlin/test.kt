import org.junit.jupiter.api

class test {
    @Test
    fun provfun()// в обр кавычках ''вместо функции можно написать на русс название теста
    // цель передать в функцию запрос Х получить результат У
    //функция сравнения assertEqvals в параметрах(У,выполняемая функция с параметрами Х
    {
        assertEqvals(Y, fun(X) )

        }

}
// второй тест
class ValidatorProc<T, R> private constructor(
    val validators: MutableList<validateHandler<T, R>> = mutableListOf(),
    private val errors: MutableList<R> = mutableListOf(),
    private val stopOnError: Boolean = false
): IValidator<T, R> {

    @ValidatorDslMarker
    class Builder<T, R> {
        private var validators: MutableList<validateHandler<T, R>> = mutableListOf()
        var stopOnError: Boolean = false

        fun build() = ValidatorProc<T, R>(
            validators = validators,
            stopOnError = stopOnError
        )


        fun validate(block: validateHandler<T, R>){
            validators.add(block)
        }


    }

    override suspend fun validate(ctx: T): MutableList<R> {
        validators.forEach {
            it(ctx)?.let {
                    it1 -> errors.add(it1)
                if (stopOnError) return errors
            }
        }
        return errors
    }
}