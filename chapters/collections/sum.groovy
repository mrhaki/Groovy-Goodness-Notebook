def n = 0..5 as Integer[]

assert n instanceof Integer[]
assert n.sum() == 0 + 1 + 2 + 3 + 4 + 5
assert n.sum(10) == 10 + 0 + 1 + 2 + 3 + 4 + 5
assert n.sum { it * 10 } == 0 + 10 + 20 + 30 + 40 + 50
assert n.sum(10, { it * 10 }) == 10 + 0 + 10 + 20 + 30 + 40 + 50


def numbers = [1, 2, 3, 4, 5, 6]
assert numbers.sum() == 21
assert numbers.sum(10) == 31

class Product {
    String name
    BigDecimal price

    BigDecimal plus(Product other) {
        price + other.price
    }
}
def products = [new Product(name: 'laptop', price: 999), new Product(name: 'netbook', price: 395)]

assert products.sum() == 1394
