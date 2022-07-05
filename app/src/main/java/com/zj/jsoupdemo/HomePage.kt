package com.zj.jsoupdemo

import me.ghui.fruit.Attrs
import me.ghui.fruit.annotations.Pick

data class HomePage(
    @Pick(
        value = "body > div.foucs.bg > div.hero-wrap > ul > li"
    )
    var bannerList: List<Banner>? = null,
    @Pick(
        value = "div.firs.l > div"
    )
    var groupList: List<Group>? = null
) {
    data class Banner(
        @Pick(
            value = "a",
            attr = Attrs.HREF
        )
        var url: String? = null,
        @Pick(
            value = "a > img",
            attr = Attrs.SRC
        )
        var avatar: String? = null,
        @Pick(
            value = "a > p",
            attr = Attrs.TEXT
        )
        var name: String? = null
    )

    data class Group(
        @Pick(
            value = "div.dtit > h2 > a",
            attr = Attrs.TEXT
        )
        var groupName: String? = null,
        @Pick(
            value = "div.img > ul > li",
        )
        var itemList: List<Item>? = null,
    ) {
        data class Item(
            @Pick(
                value = "a > img",
                attr = Attrs.SRC
            )
            var cover: String? = null,
            @Pick(
                value = "p.tname > a",
                attr = Attrs.TEXT
            )
            var name: String? = null,
            @Pick(
                value = "a",
                attr = Attrs.HREF
            )
            var url: String? = null
        )
    }
}
