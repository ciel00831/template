package com.tiny.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiny.common.CommonTest;
import com.tiny.document.Document;

public class DocumentDaoTest extends CommonTest {
	@Autowired
	private DocumentDao documentDao;

	@Test
	public void save() {
		// Given
		int count = documentDao.count();

		// When
		documentDao.save(createDocument());

		// Then
		assertThat(documentDao.count(), is(count + 1));
	}

	@Test
	public void get() {
		// Given
		documentDao.save(createDocument());

		// When
		Document document = documentDao.getLast();

		// Then
		assertThat(document.getContent(), is(createDocument().getContent()));
	}

	@Test
	public void update() {
		// Given
		documentDao.save(createDocument());
		int count = documentDao.count();

		// When
		documentDao.update(createDocument());

		// Then
		assertThat(documentDao.count(), is(count));
	}

	@Test
	public void delete() {
		// Given
		documentDao.save(createDocument());
		int count = documentDao.count();

		// When
		documentDao.delete(documentDao.getLast().getDocumentId());

		// Then
		assertThat(documentDao.count(), is(count - 1));
	}

	private Document createDocument() {
		Document document = new Document();
		document.setContent("content");
		document.setProviderUserId("userId");
		document.setIpAddress("127.0.0.1");
		document.setRegDate(new Date());
		return document;
	}
}
