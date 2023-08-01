import java.net.URL
import kotlin.random.Random
import kotlin.random.nextInt

//open class Book (val title: String, val author: String) {
//    private var currentPage = 1
//
//    open fun readPage() {
//        currentPage++
//    }
//}
//
//class eBook(title: String, author: String, val format: String = "text") : Book(title, author) {
//    private var wordCount = 0
//
//    override fun readPage() {
//        super.readPage()
//        wordCount += 250
//    }
//}

const val MAX_BOOKS_TO_BORROW = 5
data class Book(val title: String, val author: String, val year: Int) {
    companion object {
        const val BASE_URL = "http://library.com"
    }
    fun titleAndAuthor() = title to author
    fun titleAutohrAndYear() = Triple(title, author, year)

    fun canBorrow(userBorrowed: Int) = userBorrowed < MAX_BOOKS_TO_BORROW

    fun printUrl() = "$BASE_URL/$title.html"

    var pages: Int = 500
}

fun Book.weight() = this.pages * 1.5
fun Book.tornPages(pages: Int) {
    this.pages -= pages
}

class Puppy {
    fun playWithBook(book: Book) {
        book.pages -= Random.nextInt(book.pages + 1)
    }
}


fun main() {
    val book = Book("Nine Princes in Amber", "Roger Zelazny", 1970)
    val (title, author, year) = book.titleAutohrAndYear()
    println("Here is your book $title written by $author in $year.")

    val allBooks = setOf(
        book,
        Book("The Guns of Avalon", "Roger Zelazny", 1972),
        Book("Sign of the Unicorn", "Roger Zelazny", 1975),
        Book("The Hand of Oberon", "Roger Zelazny", 1976),
        Book("The Courts of Chaos", "Roger Zelazny", 1978)
    )

    val library = mapOf(book.author to allBooks)
    println(library.any { it.value.any { it.title.contains("Guns") } })


    val moreBooks = library.toMutableMap()
    println(moreBooks)
    moreBooks.getOrPut("J. R. R. Tolkien") {
        setOf(
            Book("The Hobbit, or There and Back Again ", "J. R. R. Tolkien", 1937),
            Book("The Lord of the Rings", "J. R. R. Tolkien", 1949)
        )
    }
    println(moreBooks)

    val puppy = Puppy()
    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("Pages left: ${book.pages}" )
    }

}