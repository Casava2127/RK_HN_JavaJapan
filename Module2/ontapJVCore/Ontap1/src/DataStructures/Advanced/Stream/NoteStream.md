Ok, bạn đang đi đúng lộ trình 🚀. Sau khi học **Lambda**, bước tiếp theo chính là **Stream API** (giới thiệu ở Java 8). Mình giải thích từ từ nhé:

---

## 🔹 1. **Stream API là gì?**

* **Stream API** là một công cụ trong Java 8 để xử lý **dữ liệu dạng collection (List, Set, Map, Array)** theo cách:

    * **Khai báo** (declarative) thay vì viết vòng lặp thủ công.
    * **Ngắn gọn** hơn nhờ kết hợp với **Lambda Expression**.
    * **Hướng functional programming** (lập trình hàm).

👉 Nghĩ nó giống như **dòng chảy dữ liệu** (stream), bạn áp dụng các bước xử lý (filter, map, sort, reduce, …) rồi cuối cùng thu được kết quả.

---

## 🔹 2. **Cấu trúc xử lý bằng Stream**

Quy trình thường gồm 3 bước:

1. **Source** – nguồn dữ liệu (Collection, Array, I/O, …)

   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   ```

2. **Intermediate Operations** – các thao tác trung gian (không thay đổi dữ liệu gốc, tạo stream mới)
   Ví dụ: `.filter()`, `.map()`, `.sorted()`.

3. **Terminal Operation** – thao tác kết thúc (trả về kết quả, hoặc thực hiện hành động)
   Ví dụ: `.forEach()`, `.collect()`, `.reduce()`.

---

## 🔹 3. **Ví dụ cơ bản**

```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Lấy số chẵn, nhân 2, rồi in ra
        numbers.stream()                       // nguồn dữ liệu
               .filter(n -> n % 2 == 0)        // lọc số chẵn
               .map(n -> n * 2)                // nhân đôi
               .forEach(System.out::println);  // in ra
    }
}
```

👉 Kết quả:

```
4
8
12
16
```

---

## 🔹 4. **Một số thao tác phổ biến**

### 1. `filter()` → lọc dữ liệu

```java
List<String> names = Arrays.asList("An", "Bình", "Chi", "Anh");
names.stream()
     .filter(name -> name.startsWith("A"))
     .forEach(System.out::println);
// Kết quả: An, Anh
```

### 2. `map()` → biến đổi dữ liệu

```java
List<String> names = Arrays.asList("An", "Bình", "Chi");
names.stream()
     .map(String::toUpperCase)
     .forEach(System.out::println);
// Kết quả: AN, BÌNH, CHI
```

### 3. `sorted()` → sắp xếp

```java
List<String> names = Arrays.asList("Chi", "An", "Bình");
names.stream()
     .sorted()
     .forEach(System.out::println);
// Kết quả: An, Bình, Chi
```

### 4. `collect()` → gom về Collection mới

```java
List<String> names = Arrays.asList("An", "Bình", "Chi");
List<String> upper = names.stream()
                          .map(String::toUpperCase)
                          .collect(Collectors.toList());
System.out.println(upper);
// Kết quả: [AN, BÌNH, CHI]
```

### 5. `reduce()` → gộp dữ liệu thành 1 giá trị

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                 .reduce(0, (a, b) -> a + b);
System.out.println(sum); 
// Kết quả: 15
```

---

## 🔹 5. **Ưu điểm của Stream API**

✅ Code ngắn gọn, dễ đọc.
✅ Dễ xử lý dữ liệu phức tạp (lọc, biến đổi, gộp).
✅ Hỗ trợ **song song** (`parallelStream()`) để tận dụng đa luồng.

---

## 🔹 6. **Ví dụ nâng cao – dùng song song**

```java
List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

int sum = numbers.parallelStream() // chạy đa luồng
                 .filter(n -> n % 2 == 0)
                 .mapToInt(n -> n)
                 .sum();

System.out.println("Tổng số chẵn = " + sum);
// Kết quả: 30
```

---

📌 **Tóm lại:**

* **Stream API** = xử lý dữ liệu Collection theo phong cách lập trình hàm.
* Kết hợp với **Lambda** sẽ cực kỳ mạnh mẽ.
* Dùng cho: lọc (`filter`), biến đổi (`map`), sắp xếp (`sorted`), gộp (`reduce`), thu kết quả (`collect`).

---
PHAN BIET INTERMEDIATE VA TERMINAL OPERATION
Chuẩn rồi 👌, mình sẽ giải thích rõ 2 ý bạn hỏi nhé:

---

## 🔹 1. Có bao nhiêu **Intermediate Operations** trong Stream API?

* **Intermediate Operation** = các thao tác trung gian, **trả về một Stream mới**, cho phép **xâu chuỗi (chain)** nhiều bước.
* Chúng **lười biếng (lazy)** → nghĩa là sẽ không chạy ngay, mà chỉ thực sự chạy khi có **Terminal Operation** (như `forEach()`, `collect()`, `reduce()`...).

👉 Một số intermediate operation phổ biến nhất:

1. **`filter(Predicate)`** – lọc phần tử theo điều kiện.
2. **`map(Function)`** – biến đổi phần tử.
3. **`flatMap(Function)`** – giống map nhưng “làm phẳng” (dùng cho List\<List<T>>).
4. **`distinct()`** – loại bỏ phần tử trùng lặp.
5. **`sorted()`** – sắp xếp.
6. **`peek(Consumer)`** – xem dữ liệu trung gian (debug).
7. **`limit(n)`** – lấy `n` phần tử đầu.
8. **`skip(n)`** – bỏ qua `n` phần tử đầu.
9. **`mapToInt`, `mapToDouble`, `mapToLong`** – ánh xạ sang stream số học.
10. **`flatMapToInt`, `flatMapToDouble`, `flatMapToLong`** – tương tự cho stream số học.

👉 Tùy trường hợp, bạn sẽ kết hợp nhiều cái lại:

```java
list.stream()
    .filter(x -> x > 10)   // lọc
    .map(x -> x * 2)       // biến đổi
    .sorted()              // sắp xếp
    .distinct()            // bỏ trùng
    .limit(5)              // lấy 5 phần tử
    .forEach(System.out::println); // terminal
```

---

## 🔹 2. `startsWith("A")` có phải phương thức của `String` không?

✅ Đúng.

* `startsWith()` là một **phương thức (method)** của lớp **`String`** trong Java.
* Nó trả về **boolean** (`true/false`).

👉 Cú pháp:

```java
boolean startsWith(String prefix)
boolean startsWith(String prefix, int toffset)
```

Ví dụ:

```java
String name = "Anh";
System.out.println(name.startsWith("A")); // true
System.out.println(name.startsWith("B")); // false
System.out.println(name.startsWith("n", 1)); // true (bắt đầu từ index=1)
```

Trong Stream API, mình chỉ kết hợp **filter + startsWith** như sau:

```java
names.stream()
     .filter(s -> s.startsWith("A"))
     .forEach(System.out::println);
```

Ở đây:

* `filter(...)` là **intermediate operation** của `Stream`.
* `startsWith("A")` là **method của String** được dùng làm điều kiện.

---

👉 Bạn có muốn mình làm một **bảng so sánh ngắn gọn giữa tất cả Intermediate Operation và Terminal Operation trong Stream** để dễ nhớ hơn không?
Rồi 👍 mình làm cho bạn một **bảng so sánh đầy đủ giữa Intermediate Operation và Terminal Operation trong Stream API** để dễ học nhé:

---

# 📌 So sánh Intermediate vs Terminal Operations trong Java Stream API

| **Tiêu chí**             | **Intermediate Operation**       | **Terminal Operation**                            |
| ------------------------ | -------------------------------- | ------------------------------------------------- |
| **Kết quả trả về**       | Một **Stream mới** (lazy)        | Một **giá trị / Collection / side effect**        |
| **Thực thi ngay không?** | ❌ Không (lazy), chỉ tạo pipeline | ✅ Có (eager), kích hoạt thực thi toàn bộ pipeline |
| **Có chain được không?** | ✅ Có (có thể nối nhiều bước)     | ❌ Không (chỉ chạy 1 lần, sau đó stream đóng lại)  |
| **Ví dụ**                | `filter()`, `map()`, `sorted()`  | `forEach()`, `collect()`, `reduce()`              |

---

## 🔹 Các **Intermediate Operations** thường dùng

| Nhóm            | Operation                              | Mô tả                                            |
| --------------- | -------------------------------------- | ------------------------------------------------ |
| **Biến đổi**    | `map(Function)`                        | Biến đổi từng phần tử                            |
|                 | `flatMap(Function)`                    | Biến đổi và làm phẳng (List\<List<T>> → List<T>) |
| **Lọc**         | `filter(Predicate)`                    | Giữ phần tử thỏa điều kiện                       |
|                 | `distinct()`                           | Loại bỏ trùng lặp                                |
| **Sắp xếp**     | `sorted()`                             | Sắp xếp tự nhiên                                 |
|                 | `sorted(Comparator)`                   | Sắp xếp theo điều kiện                           |
| **Giới hạn**    | `limit(n)`                             | Lấy n phần tử đầu                                |
|                 | `skip(n)`                              | Bỏ qua n phần tử đầu                             |
| **Khác**        | `peek(Consumer)`                       | Xem giá trị trung gian (debug)                   |
| **Chuyên biệt** | `mapToInt`, `mapToDouble`, `mapToLong` | Chuyển sang stream số học                        |
|                 | `flatMapToInt`, ...                    | Làm phẳng stream số học                          |

---

## 🔹 Các **Terminal Operations** thường dùng

| Nhóm              | Operation                                               | Mô tả                                                    |
| ----------------- | ------------------------------------------------------- | -------------------------------------------------------- |
| **Duyệt**         | `forEach(Consumer)`                                     | Lặp qua từng phần tử                                     |
|                   | `forEachOrdered(Consumer)`                              | Duyệt giữ thứ tự                                         |
| **Thu thập**      | `collect(Collectors)`                                   | Thu về `List`, `Set`, `Map`, …                           |
|                   | `toArray()`                                             | Thu về mảng                                              |
| **Tính toán**     | `reduce()`                                              | Gộp phần tử thành 1 giá trị (tổng, tích, …)              |
|                   | `count()`                                               | Đếm số phần tử                                           |
|                   | `min(Comparator)`                                       | Tìm giá trị nhỏ nhất                                     |
|                   | `max(Comparator)`                                       | Tìm giá trị lớn nhất                                     |
|                   | `average()` (chỉ với IntStream/DoubleStream/LongStream) | Tính trung bình                                          |
| **Kiểm tra**      | `anyMatch(Predicate)`                                   | Có phần tử nào thỏa điều kiện không?                     |
|                   | `allMatch(Predicate)`                                   | Tất cả phần tử có thỏa không?                            |
|                   | `noneMatch(Predicate)`                                  | Không có phần tử nào thỏa?                               |
| **Lấy 1 phần tử** | `findFirst()`                                           | Lấy phần tử đầu tiên                                     |
|                   | `findAny()`                                             | Lấy bất kỳ phần tử nào (thường dùng với parallel stream) |

---

## 🔹 Ví dụ minh họa kết hợp

```java
import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("An", "Anh", "Bình", "Chi", "An");

        long count = names.stream()
                          .filter(s -> s.startsWith("A"))  // intermediate
                          .distinct()                      // intermediate
                          .sorted()                        // intermediate
                          .peek(s -> System.out.println("Trung gian: " + s)) // intermediate
                          .count();                        // terminal

        System.out.println("Số tên bắt đầu bằng A (không trùng): " + count);
    }
}
```

👉 Kết quả:

```
Trung gian: An
Trung gian: Anh
Số tên bắt đầu bằng A (không trùng): 2
```

---

📌 **Tóm lại:**

* **Intermediate** = “chuẩn bị đường ống xử lý dữ liệu” (lazy).
* **Terminal** = “kích hoạt và kết thúc pipeline” (eager).
* Khi chưa có **terminal operation**, thì intermediate operations **chưa chạy**.
  có nghĩa terminal kích hoạt đường ống Stream → Intermediate → Terminal
---
