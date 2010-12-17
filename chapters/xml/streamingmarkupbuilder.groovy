import groovy.xml.*

def markupBuilder = new StreamingMarkupBuilder()
def xml = markupBuilder.bind { builder ->
    client {
        name 'mrhaki'
        fullName 'Hubert A. Klein Ikkink'
        buildAddress builder, 'Main St.', 42, 'Ducktown'
        delivery {
            buildAddress builder, 'Main Av.', 101, 'Springfield'
            remarks 'During office hours'
        }
        buildItems builder
    }
}

def buildAddress(builder, streetName, number, city) {
    builder.address {
        street streetName
        houseNumber number
        buildCity builder, city
    }
}

def buildCity(builder, city) {
    builder.city city
}

def buildItems(builder) {
    builder.items {
        ['iPod', 'eBook'].eachWithIndex { product, index ->
            item(id: index + 1) {
                name "Item $product"
            }
        }
    }
}

assert XmlUtil.serialize(xml) == '''<?xml version="1.0" encoding="UTF-8"?>
<client>
  <name>mrhaki</name>
  <fullName>Hubert A. Klein Ikkink</fullName>
  <address>
    <street>Main St.</street>
    <houseNumber>42</houseNumber>
    <city>Ducktown</city>
  </address>
  <delivery>
    <address>
      <street>Main Av.</street>
      <houseNumber>101</houseNumber>
      <city>Springfield</city>
    </address>
    <remarks>During office hours</remarks>
  </delivery>
  <items>
    <item id="1">
      <name>Item iPod</name>
    </item>
    <item id="2">
      <name>Item eBook</name>
    </item>
  </items>
</client>
'''
