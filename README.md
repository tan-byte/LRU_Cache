# 🔁 LRU Cache Implementation (Java)

## 📌 Overview
This project implements a **Least Recently Used (LRU) Cache** using **HashMap** and a **Doubly Linked List**.

The cache supports **O(1)** time complexity for both `get()` and `put()` operations and is designed as a **reusable, generic Java component**.

This project was built to deepen understanding of **data structures, caching mechanisms, and system design fundamentals**.

---

## 🧠 What is an LRU Cache?
An LRU (Least Recently Used) Cache evicts the item that has not been accessed for the longest time when the cache reaches its maximum capacity.

It is widely used in:
- Operating systems
- Web browsers
- Databases
- Distributed systems

---

## ⚙️ Design Approach

### Data Structures Used
- **HashMap<K, Node>**
  - Provides O(1) access to cache entries.
- **Doubly Linked List**
  - Maintains usage order.
  - Most recently used item at the front.
  - Least recently used item at the back.

### Why This Works
- HashMap ensures fast lookup.
- Doubly Linked List allows O(1) insertion, deletion, and reordering.
- Dummy head and tail nodes simplify edge-case handling.

---

## 🚀 Features
- Generic key-value support
- Fixed cache capacity
- Automatic eviction of least recently used entry
- Clean OOP design
- Easy to extend (TTL, thread safety, statistics)

---

## ⏱️ Time & Space Complexity

| Operation | Complexity |
|---------|------------|
| get()   | O(1)       |
| put()   | O(1)       |

**Space Complexity:** O(capacity)

---

## 🧪 Example Usage

```java
LRUCache<Integer, String> cache = new LRUCache<>(2);
cache.put(1, "A");
cache.put(2, "B");
cache.get(1);
cache.put(3, "C"); // Evicts key 2
