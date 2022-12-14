package personOOP

import java.time.LocalDate

class Person2(var name: String, var age: Int) {
    var birthyear = LocalDate.now().year - age
}
