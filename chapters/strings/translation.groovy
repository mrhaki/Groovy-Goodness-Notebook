// Source set and replacement set are equal size.
assert 'I love Groovy'.tr('loeG', '1039') == 'I 10v3 9r00vy'

// Regular expression style range
assert 'mrhaki'.tr('a-k', 'A-K') == 'mrHAKI'

// Replacement set is smaller than source set.
assert 'Groovy'.tr('ovy', '8') == 'Gr8888'
