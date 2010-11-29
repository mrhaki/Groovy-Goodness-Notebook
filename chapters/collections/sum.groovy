def n = 0..5 as Integer[]

assert n instanceof Integer[]
assert      0 + 1 + 2 + 3 + 4 + 5 == n.sum()
assert 10 + 0 + 1 + 2 + 3 + 4 + 5 == n.sum(10)
assert      0 + 10 + 20 + 30 + 40 + 50 == n.sum { it * 10 }
assert 10 + 0 + 10 + 20 + 30 + 40 + 50 == n.sum(10, { it * 10 })


def numbers = [1, 2, 3, 4, 5, 6]
assert 21 == numbers.sum()
assert 31 == numbers.sum(10)

class Product {
    String name
    BigDecimal price

    BigDecimal plus(Product other) {
        price + other.price
    }
}
def products = [new Product(name: 'laptop', price: 999), new Product(name: 'netbook', price: 395)]

assert 1394 == products.sum()
