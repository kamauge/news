package com.regera.news.db

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.content.pm.ApplicationInfoBuilder
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ArticleDaoTest {
    private lateinit var database: ArticleDatabase
    private lateinit var articleDao: ArticleDao


    @Before
    fun setUp(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ArticleDatabase::class.java
        ).allowMainThreadQueries().build()

        articleDao = database.getArticleDao()
    }

    @After
    fun tearDown(){
        database.close()
    }


    @Test
    fun upsert() = runBlockingTest {
        
    }


}