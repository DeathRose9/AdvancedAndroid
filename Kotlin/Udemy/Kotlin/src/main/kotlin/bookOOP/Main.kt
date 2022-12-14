package bookOOP

fun main(){
    val book = Book("The Stranger", "Albert Camus", 1942, true)
    book.bookInfo()
    book.borrow() // Sorry, the book is already borrowed.
    book.returnBook() // Thank you. You just returned "The Stranger" by Albert Camus.
    book.returnBook() // You cannot return the book "The Stranger" as it was not borrowed.
    book.borrow() // You borrowed "The Stranger" by Albert Camus.
}
