package L08IteratorsAndComparators.P02Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    private class LibraryIterator implements Iterator<Book> {
        private int index;

        public LibraryIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }
}
