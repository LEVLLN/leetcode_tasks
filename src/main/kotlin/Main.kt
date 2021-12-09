import java.util.Stack

fun firstUniqueCharacter(s: String): Int {
    // https://leetcode.com/problems/first-unique-character-in-a-string/
    val frequenciesByFirstChar = s.groupingBy { it.toChar() }.eachCount()
    var result: Int = -1

    for (uniqueChar in frequenciesByFirstChar) {
        if (uniqueChar.component2() == 1) {
            result = s.indexOf(char = uniqueChar.component1())
            break
        }
    }
    return result
}

fun reverseString() {
    // https://leetcode.com/problems/reverse-string/
    val s: CharArray = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
    s.reverse()
    val f = mapOf(1 to 2).keys
}

fun validAnagram(s: String, t: String): Boolean {
    // Anagram validation
    return s.groupingBy { it }.eachCount() == t.groupingBy { it }.eachCount()
}

fun containsDoubles(nums: IntArray): Boolean {
    // https://leetcode.com/problems/contains-duplicate/
    val marker: MutableSet<Int> = mutableSetOf()
    for (i in nums) {
        if (marker.contains(i)) {
            return true
        }
        marker.add(i)
    }
    return false
}

fun reverseInteger(num: Int): Int {
    // https://leetcode.com/problems/reverse-integer/
    if (num > 0) return num.toString().reversed().toInt()
    if (num < 0) return -1 * num.toString().reversed().replace(oldValue = "-", newValue = "").toInt()
    return 0
}

fun validPalindrome(s: String): Boolean {
    // https://leetcode.com/problems/valid-palindrome/ проверить валидность палиндрома
    val palindrome = s.lowercase().filter { it.isLetterOrDigit() }
    val strSize = palindrome.length - 1

    for (i in palindrome.indices) {
        if (palindrome[i] != palindrome[strSize - i]) return false
    }

    return true
}


fun fizzBuzz(n: Int): List<String> {
    // https://leetcode.com/problems/fizz-buzz/
    return List<String>(n) {
        val x = it + 1
        when {
            x % 15 == 0 -> "FizzBuzz"
            x % 3 == 0 -> "Fizz"
            x % 5 == 0 -> "Buzz"
            else -> x.toString()
        }
    }
}
fun acrossLists(l1: IntArray, l2: IntArray): List<Int> {
    // Items from list 1 overlap with list 2. With Doubles
    // Example. l1= [1, 2, 2, 2, 5] l2=[1, 3, 5, 2, 2]. result=[1, 2, 2, 5]
    val result: MutableList<Int> = mutableListOf()
    val intersection = l1.intersect(l2.toList())

    for (i in intersection) {
        val count = minOf(l2.count {it == i}, l1.count { it == i })
        repeat(count) {result.add(i)}
    }
    return result
}

fun String.countedLetter(letter: Char, count: Int): String = "$this${letter}$count"


fun countLetters(letters: String): String {
    // Count letters are in a row by format: AAABBBAACCCC -> A3B3A2C4
    var result: String = ""
    var count = 0
    for (i in letters.indices) {
        count ++
        if (i == letters.length - 1) {
            result = result.countedLetter(letters[i], count)
            break
        }
        if (letters[i] != letters[i + 1]) {
            result = result.countedLetter(letters[i], count)
            count = 0
        }

    }
    return result
}

fun bracketsWithArrayDequeue(s: String): Boolean {
    // https://leetcode.com/problems/valid-parentheses/
    // Проверить валидность скобочного выражения. Все ли скобки открыты и закрыты. Любой уровень вложенности
    // {{}} -> True
    // (()) -> True
    // (() -> False
    // Solution ArrayDeque
    val stack: ArrayDeque<Char> = ArrayDeque<Char>()
    val brackets: Map<Char, Char> = mapOf(
        '(' to ')',
        '[' to ']',
        '{' to '}'
    )
    for (i in s) {
        if (i in brackets.keys) {
            stack.addLast(i)
            continue
        }
        if (stack.isEmpty() || i != brackets[stack.last()]) return false
        stack.removeLast()
    }
    return stack.isEmpty()
}

fun bracketsWithStack(s: String): Boolean {
    // https://leetcode.com/problems/valid-parentheses/
    // {{}} -> True
    // (()) -> True
    // (() -> False
    // Solution via java.util.Stack
    val stack: Stack<Char> = Stack<Char>()
    val brackets: Map<Char, Char> = mapOf('(' to ')', '[' to ']', '{' to '}')
    for (i in s) {
        if (i in brackets.keys) {
            stack.push(i)
            continue
        }
        if (stack.isEmpty() || i != brackets[stack.lastElement()]) return false
        stack.pop()
    }
    return stack.isEmpty()
}

fun implementStr(haystack: String, needle: String): Int {
    // https://leetcode.com/problems/implement-strstr/
    // TODO: Optimize this solution by Memory
    if (needle == "") return 0
    var i: Int = 0
    val needleLength: Int = needle.length
    haystack.windowed(needleLength).forEach {
        if (needle == it) {
            return i
        }
        i++
    }
    return -1
}


fun checkIfExist(arr: IntArray): Boolean {
    //https://leetcode.com/explore/featured/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
    // TODO: First-fast solution in O(n^2). Must O(n).
    for (i in arr) {
        for (j in arr) {
            if (i * 2 == j && i != 0) return true;
        }
    }
    return false;
}