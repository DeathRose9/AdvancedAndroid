package higherOrderFunction_Lambda_CompanionObject_Singleton

class CompanionObjectClass {
    companion object {
        var companionObjectVariable = 0
        fun companionObjectFun() = companionObjectVariable++
    }

    fun classFunction() {

    }
}