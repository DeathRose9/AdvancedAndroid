package bookOOP

class Book(private val title: String, private val author: String, private val publicationYear: Int, var isBorrowed: Boolean) {
    fun borrow() {
        return if (isBorrowed) {
            println("Sorry, the book is already borrowed.")
        } else {
            println("You borrowed \"$title\" by $author.")
            isBorrowed = true
        }
    }

    fun returnBook() {
        return if (isBorrowed) {
            println("Thank you. You just returned \"$title\" by $author.")
            isBorrowed = false
        } else {
            println("You cannot return the book \"$title\" as it was not borrowed.")
        }
    }

    fun bookInfo() {
        println(
            "The book title: \"$title\"," +
                    "\nAuthor: $author," +
                    "\nPublication year: $publicationYear"
        )
    }
}