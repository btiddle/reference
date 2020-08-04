big-o-notation.md

# Big O Notation

## Table of Contents
<!-- MarkdownTOC autolink="true" -->

- [Definition](#definition)
- [O\(n\) - linear](#on---linear)
- [O\(n^2\) - quadratic](#on%5E2---quadratic)
- [values of complexity: best-case, worst-case, and average-case](#values-of-complexity-best-case-worst-case-and-average-case)

<!-- /MarkdownTOC -->

## Definition


Big O Notation describes how an algorithm performs as its input changes.

## O(n) - linear

An algorithm with O(n) is said to have _linear_ complexity: As the size of the
input, n, increases, the performance of the algorithm increases by a 
proportional amount.

## O(n^2) - quadratic

O(n2) means that as the size of the input doubles, the algorithm takes four
times longer to run.

An O(n^2) complexity is said to be _quadratic_: if you tripled the size of the
input, the algorithm would take nine times longer to run. As you would expect,
quadratic, or worse, exponential (O(n^n)) algorithms should be avoided where
possible.

The Big O Notation for the original implementation (same values are calculated 
multiple times) to calculate the nth Fibonacci number, is O(n^n), and thus is
extremely inefficient; too inefficient for anything useful than very low values
of n. 

```
// A recursive algorithm for finding the nth Fibonacci number

public static int fibN(int n) {
    if (n < 0) {
        throw new IllegalArgumentException(
                "n must not be less than zero");
    }
    if (n == 1) return 1;
    if (n == 0) return 0;
    return (fibN(n - 1) + fibN(n - 2));
}

```
When the result of a method call is cached to save recalculating the result
again later, this is called memoization. The memoized implementation has O(n),
with the additional stipulation that it must store each value between 0 and n.

```
// Caching previously computed Fibonacci numbers

private Map<Integer, Integer> fibCache = new HashMap<>();
public int cachedFibN(int n) {
    if (n < 0) {
        throw new IllegalArgumentException(
                "n must not be less than zero");
    }
    fibCache.put(0, 0);
    fibCache.put(1, 1);
    return recursiveCachedFibN(n);
}
private int recursiveCachedFibN(int n) {
    if (fibCache.containsKey(n)) {
        return fibCache.get(n);
    }
    int value = recursiveCachedFibN(n - 1) + recursiveCachedFibN(n - 2);
    fibCache.put(n, value);
    return value;
}
```

## values of complexity: best-case, worst-case, and average-case

As you would expect, a best-case performance is how the algorithm performs when the input
given means the algorithm does as little work as possible.

The performance descriptions here are often called the time complexity of the algorithm.
Algorithms have a space complexity, too; that is, how much extra space the algorithm needs
to do its work.

There is often a trade-off. You may find that the best performing algorithm uses much more space
than you can afford, or that the algorithm that uses only one extra piece of memory is much less
efficient than alternatives that use more space.


