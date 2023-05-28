package com.karrot42.account.repository

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.r2dbc.spi.ConnectionFactory
import org.junit.jupiter.api.Disabled
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.r2dbc.core.DatabaseClient

internal class AccountRepositoryTest (
) : FreeSpec({
})

//@DataR2dbcTest
//@Disabled
//class PostRepositoryTest {
//
//    @Autowired
//    private lateinit var posts: PostRepository
//
//    @Autowired
//    private lateinit var client: DatabaseClient
//
//    @Test
//    fun `get all posts`() {
//        val inserted = client.insert().into<Post>().table("posts")
//            .using(Post(title = "mytitle", content = "mycontent"))
//            .map { row, rowMetadata -> row.get(0) }
//            .one() as Long
//
//        println("inserted id:$inserted")
//
//        runBlocking {
//            val post = posts.findOne(inserted)
//            assertEquals("mytitle", post?.title)
//            assertEquals("mycontent", post?.content)
//        }
//
//    }
//
//}
