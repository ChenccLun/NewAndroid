package com.example.newandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Global {
    public static final int aa=0;
    public static final List<List<String>> BookList = new List<List<String>>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<List<String>> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(List<String> strings) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends List<String>> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends List<String>> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean equals(@Nullable Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public List<String> get(int index) {
            return null;
        }

        @Override
        public List<String> set(int index, List<String> element) {
            return null;
        }

        @Override
        public void add(int index, List<String> element) {

        }

        @Override
        public List<String> remove(int index) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<List<String>> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<List<String>> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<List<String>> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
}
