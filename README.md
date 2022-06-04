# Truecaller
Maven project generted with com.a9ski:quick-start archetype


# Development guide
1. Install pre-commit (https://pre-commit.com/)
2. Install the pr-commit hook by executing `pre-commit install` inside project directory
3. Run against all files in the project: `pre-commit run --all-files`


# Question
Given a list of string prefixes of variable length, the assignment is to implement a method that takes a string as a parameter,
and returns the longest prefix that matches the input string. A prefix matches if the input string starts with that prefix.

# Approach
1. We first build a trie with all the words in the list.
2. While building the trie, we take advantage of the recursion and use the return value
to store the longest prefix starting from the current node.
3. When we want to get the longest prefix for a word, we trace the path of the traversal.
 There are two conditions possible while traversing the trie with the given word as input.

# Case 1
The height of the trie is less than the input length. In the case, we return the path traced so far.

Example :- Consider these inputs\
BuildTrie(aaa)\
findLongestPrefix(aaaa) returns "aaa"

Here, the height of our trie is 3 (excluding the default root node).
And it is less than input length, so we return "aaa" as answer.
This can be tweaked obviously to return another result as desired.

# Case 2
The length of the input is less than or equal to the height of the trie.
In that case, when we arrive at the node that contains the last index of the string,
we have two information available so far.
1) The path that we traced so far while reaching at the current node.
2) And the longest prefix possible from the current node. We get this in constant time since we already built that
   while building our trie.

We can simply return the concatenation of these two values as our answer.

# Example
Consider these two inputs :\
BuildTrie(aaad, aaaad)\
findLongestPrefix(aaa) returns aaaad.

Here, the height of the trie is 5. Our trie will look like this\
![Alt text](src/test/resources/org/example/trie.jpg?raw=true "Title")\


When we process aaa, we receive at the third "a" node.
Our path traced so far is "aaa" and the longest prefix from the node is "ad".
Thus, our answer will be "aaa" + "ad" = "aaaad".

# Assumptions
In case of inputs like the below :-\
BuildTrie(abc, acd)\
findLongestPrefix(a) can return abc or acd.

Our solution will return the first prefix from left to right i.e. abc in the list. This can of course be tweaked to 
return all the strings or the most recent prefix in the list.


# Complexity Analysis
Let us examine the complexity of our trie operations.\
BuildTrie(word) -> O(n) where n is the length of the input string.\
findLongestPrefix(word) -> O(min(n, h)) where n is the length of the string and h is the height of the trie.

Thus, building the trie from the list will take O(n) * len when len is the number of strings in the list and n is the maximum length among the inputs.

Space Complexity :-\
In the worst case where every prefix is different from each other, \
we will need n nodes where n is the total number of characters in the input.




