package com.gl.java.Stream;

import com.gl.java.deepcopy.Student;
import com.gl.java.equal.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamDemo {
    static Map<Integer, Book> mCache = null;
    static volatile List<Book> allianceMembers;

    public static void main(String args[]) {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        Stream<String> stream3 = list.stream().flatMap(l -> {
            String[] strings = l.split("");
            return Arrays.stream(strings);
        });
        stream3.forEach(System.out::println);

        mCache = new HashMap<>();
        List<Book> bookList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Book book = new Book(i, "book" + i, "desc" + i);

            bookList.add(book);
        }
        allianceMembers = Collections.unmodifiableList(bookList);

        for (int j = 0; j < bookList.size(); j++) {
            Book book = bookList.get(j);
            mCache.put(book.getId(), book);
        }
        System.out.println(mCache.toString());
        Book book = mCache.get(2);
        book.setName("book22");
        book.setDesc("des22");
        mCache.put(book.getId(), book);
        System.out.println(Arrays.asList(allianceMembers).toString());
    }
}
