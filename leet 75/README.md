## 01-matrix

**Problem**: Replace each `1` in a binary matrix with the distance to the nearest `0` cell.

**Logic**:

1. Push coordinates of every `0` into a queue with starting distance `0` and mark all `1`s as `inf`.
2. Pop cells from the queue (BFS). If the stored distance is smaller than the current cell value, update the matrix.
3. For each popped cell, explore its four neighbors. Unvisited `inf` cells are enqueued with distance `+1`.
4. BFS guarantees that the first time we reach a cell is the minimal distance.

**Python notes**:

- Uses `collections.deque` for an efficient FIFO queue; `popleft()` runs in O(1).
- `float('inf')` acts as a placeholder for "not yet processed".
- A `set` tracks visited cells to avoid re-enqueuing the same coordinates.

## Binary Tree Zigzag Level Order Traversal

**Problem**: Traverse a binary tree level by level, reversing the order of nodes every other level.

**Logic**:

1. Standard BFS collects nodes level by level.
2. After processing a level, reverse the list when the current depth is odd to create the zigzag effect.

**Python notes**:

- `deque([root])` seeds the queue if the tree is non-empty.
- `list(reversed(level))` builds a new list in the opposite order; for large levels this has a cost, but it keeps the code simple.

## Can Place Flowers

**Problem**: Given a flowerbed array of `0`s and `1`s, determine if `n` new flowers can be planted without adjacent flowers.

**Logic**:

1. Pad the array with `0` at both ends so edge plots have virtual empty neighbors.
2. Scan the array; when a `0` has empty neighbors on both sides, plant a flower (set to `1`) and decrement `n`.
3. Early exit is not required; return whether `n` is at most `0` at the end.

**Python notes**:

- The bed is modified in-place, so if you need the original order make a copy first.
- The expression `flowerbed = [0] + flowerbed + [0]` constructs a new list by concatenation.

## Capacity to Ship Packages Within D Days

**Problem**: Find the minimal ship capacity that transports all packages in order within `days`.

**Logic**:

1. Binary search on capacity between `max(weights)` and `sum(weights)`.
2. For each candidate capacity, simulate loading packages; when the running sum exceeds capacity, start a new day.
3. If the required days are within the limit, search the lower half; otherwise search higher.

**Python notes**:

- A nested helper function `canship` closes over `weights` and `days`.
- Integer division `//` determines the midpoint without floating point.

## Course Schedule

**Problem**: Given prerequisites, decide if all courses can be finished.

**Logic**:

1. Build an adjacency list mapping each course to its prerequisites.
2. Perform DFS for each course. A recursion stack (`visited` set) detects cycles.
3. After visiting all prerequisites for a course, clear its list to memoize completion.

**Python notes**:

- Recursion depth can become large; iterative approaches or `sys.setrecursionlimit` may be needed for bigger graphs.
- `set()` membership checks run in amortized O(1), making cycle detection efficient.

## Find All Anagrams in a String

**Problem**: Return starting indices of all anagrams of `p` found in `s`.

**Logic**:

1. Build frequency maps for `p` and the first window of `s`.
2. Slide the window one character at a time: add the new char on the right and decrement/remove the char on the left.
3. When the two frequency maps match, record the current left index.

**Python notes**:

- Dictionaries use `get(key, 0)` to supply defaults when a key is absent.
- After decrementing, `pop()` removes zero-count entries so equality check works.

## Greatest Common Divisor of Strings

**Problem**: Find the largest string that can be repeated to form both `str1` and `str2`.

**Logic**:

1. Iterate over possible prefix lengths from `min(len1, len2)` down to `1`.
2. A helper verifies if a prefix of length `l` repeated forms both strings.

**Python notes**:

- String multiplication (`prefix * n`) repeats a substring.
- Early exit once a valid divisor is found.

## Greatest Number of Candies

**Problem**: For each child, determine if giving them `extraCandies` makes them have the greatest number.

**Logic**:

1. Compute the current maximum.
2. For each child, check if `candies[i] + extraCandies >= max_value`.

**Python notes**:

- Implemented with a list comprehension for clarity.

## Group Anagrams

**Problem**: Group words that are anagrams of each other.

**Logic (counting)**:

1. For each word, build a 26-length count array keyed by character ordinal differences.
2. Use the tuple of counts as a dictionary key to collect anagrams.

**Logic (sorting)**:

1. Sort each word alphabetically and use the sorted string as the key.

**Python notes**:

- `defaultdict(list)` automatically creates lists for new keys.
- `''.join(sorted(i))` converts a list of sorted characters back into a string; `join` concatenates all items of the list.

## Increasing Triplet Subsequence

**Problem**: Determine if there exists `i < j < k` such that `nums[i] < nums[j] < nums[k]`.

**Logic**:

1. Track the smallest and second smallest numbers seen so far.
2. If a number greater than both is found, a triplet exists.

**Python notes**:

- `float('inf')` initializes sentinels larger than any input.
- Use `<=` to correctly handle duplicates.

## Koko Eating Bananas

**Problem**: Koko wants the minimum integer eating speed to finish piles within `h` hours.

**Logic**:

1. Binary search over possible speeds from `1` to `max(piles)`.
2. For a candidate speed `k`, sum `math.ceil(pile / k)` over all piles to compute hours needed.
3. Adjust search based on whether hours exceed `h`.

**Python notes**:

- `math.ceil` rounds up fractional hours; ensure to `import math` in standalone scripts.

## Max Number of K-Sum Pairs

**Problem**: Maximum number of disjoint pairs that sum to `k`.

**Logic**:

1. Traverse numbers and store counts in a dictionary.
2. For each number, check if its complement has a stored count > 0; if so, form a pair and decrement.

**Python notes**:

- `d.get(num, 0)` provides a default of `0` to avoid `KeyError`.
- Pairs are counted greedily in one pass.

## Merge Strings Alternately

**Problem**: Merge two strings by alternating characters.

**Logic**:

1. Use two pointers to traverse both strings.
2. Append characters to a list in alternating order until one string ends, then append the remainder of the other.

**Python notes**:

- `return ''.join(returnList)` concatenates the list of characters into the final string; `join` is more efficient than repeated `+` concatenation.

## Minimum Number of Days to Make m Bouquets

**Problem**: Find the earliest day to make `m` bouquets using consecutive flowers of size `k`.

**Logic**:

1. If `m*k` exceeds total flowers, return `-1` immediately.
2. Binary search over days between `min(bloomDay)` and `max(bloomDay)`.
3. For each day guess, scan `bloomDay` counting consecutive flowers; every `k` consecutive blooms adds one bouquet.

**Python notes**:

- Integer division `count // k` gives number of bouquets from a streak.
- Uses a nested helper `canFormBouq`.

## Product of Array Except Self

**Problem**: Return array where each element is the product of all other elements.

**Logic**:

1. First pass builds prefix products to the left of each index.
2. Second pass multiplies the prefix value by a running postfix product from the right.

**Python notes**:

- Avoids division to handle zeros.
- `result = [1] * len(nums)` initializes the output with multiplicative identity.

## Reverse Vowels of a String

**Problem**: Reverse only the vowels in a string.

**Logic**:

1. Convert the string to a list to allow in-place swaps.
2. Use two pointers moving from both ends; swap when both pointers land on vowels.

**Python notes**:

- The vowel set includes both lowercase and uppercase characters.
- `"".join(s)` builds the final string from the modified list.

## Reverse Words in a String

**Problem**: Reverse word order, removing leading/trailing and extra middle spaces.

**Logic**:

1. Trim whitespace with `strip` and split into words (default `split()` collapses multiple spaces).
2. Reverse the list and join with single spaces.

**Python notes**:

- `" ".join(words)` uses a space as the separator when rebuilding the sentence.

## Rotting Oranges

**Problem**: Minimum minutes for all fresh oranges to rot given that rotten oranges contaminate adjacent cells each minute.

**Logic**:

1. Enqueue all initially rotten oranges.
2. BFS by layers, rotting adjacent fresh oranges and tracking elapsed time until none remain.

**Python notes**:

- The queue stores only coordinates; time is tracked by outer loop iterations.
- Grid bounds are checked to avoid index errors.

## Shortest Path in Binary Matrix

**Problem**: Length of the shortest path from top-left to bottom-right in a binary matrix, moving in eight directions.

**Logic**:

1. BFS from `(0,0)` if it is clear (`0`), storing coordinates and path length.
2. Skip out-of-bounds or blocked cells and mark visited positions.
3. Return length once bottom-right is reached; otherwise `-1`.

**Python notes**:

- `deque([(0,0,1)])` seeds the queue with a tuple containing starting length `1`.
- The `visited` set prevents revisiting cells.

## Sort Characters by Frequency

**Problem**: Sort characters in a string by decreasing frequency.

**Logic**:

1. Count occurrences of each character in a dictionary.
2. Sort dictionary items by count in reverse order.
3. Build the result by repeating each character `count` times.

**Python notes**:

- `dict(sorted(...))` returns a regular dictionary whose iteration order preserves the sort in Python 3.7+.
- String concatenation `res += key * value` multiplies characters.

## String Compression

**Problem**: Compress sequences of the same character in-place using the form `char` followed by count.

**Logic**:

1. Iterate over the array counting consecutive groups.
2. Write the character and, if needed, its count at the current insert position.
3. Use slice assignment to write multi-digit counts.

**Python notes**:

- `chars[insert:insert+len(num)] = list(num)` replaces a slice with multiple characters derived from the count string.
- Function returns the new length (`insert`).

## Top K Frequent Elements

**Problem**: Return the `k` most frequent integers.

**Logic**:

1. Build a frequency map.
2. Use a list of buckets where index represents frequency; append numbers into their corresponding bucket.
3. Walk the buckets from high to low until `k` elements are collected.

**Python notes**:

- `freq = [[] for _ in range(len(nums) + 1)]` preallocates buckets.
- Nested loops append results without explicit sorting.

## Top K Frequent Words

**Problem**: Return the `k` most frequent words; ties broken lexicographically.

**Logic**:

1. Same bucket idea as above but the buckets store words.
2. Before collecting from a bucket, sort its words alphabetically to satisfy the tie-breaking rule.

**Python notes**:

- `freq[i].sort()` sorts in-place.
- Ensure to iterate buckets from highest frequency downward.

## Two Sum

**Problem**: Find indices of the two numbers in `nums` that add up to `target`.

**Logic**:

1. Traverse the array, storing each number's index in a hash map.
2. For each element, check if `target - num` exists in the map; if so, return the pair of indices.

**Python notes**:

- Dictionary lookups are O(1) on average, enabling a single-pass solution.
- The function returns immediately upon finding the first valid pair.

## Two Sum II – Input Array Is Sorted

**Problem**: Same as Two Sum, but the input array is sorted and indices are 1-based.

**Logic**:

1. Use two pointers at the start and end of the array.
2. Move pointers inward based on the current sum compared to the target.

**Python notes**:

- Returns `[front + 1, back + 1]` to convert to 1-based indexing.

## Unique Binary Search Trees

**Problem**: Count how many structurally unique BSTs store values `1…n`.

**Logic**:

1. Dynamic programming where `numTree[i]` holds the result for `i` nodes.
2. For each possible root, multiply the number of left and right subtree shapes and accumulate.

**Python notes**:

- Initializes `numTree` with ones for `0` and `1` nodes as base cases.
- Outer loop runs from `2` to `n` inclusive.

## Valid Anagram

**Problem**: Decide if string `t` is an anagram of string `s`.

**Logic**:

1. If lengths differ, immediately return `False`.
2. For each unique character in `s`, compare its counts in both strings.

**Python notes**:

- `s.count(c)` scans the entire string each time; for large inputs a frequency dictionary would be more efficient.
- Returns `True` only if all characters match in frequency.
