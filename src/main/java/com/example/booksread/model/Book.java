package com.example.booksread.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.booksread.controller.utility.FormatWithLocale;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
	@SequenceGenerator(name = "book_gen", sequenceName = "BOOK_SEQ", allocationSize = 1)
	private long bookId;

	@Column(nullable = false)
	private String title;

	@Column
	private String series;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "authorId"))
	private List<Author> authors;

	@Column(nullable = false)
	private boolean read;

	@Column(nullable = false)
	private String asin;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateRead;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishedDate;

	public Book() {
	}

	public Book(String title, String series, List<Author> authors, boolean read, String asin, LocalDate dateRead,
			LocalDate publishedDate) {
		super();
		this.title = title;
		this.series = series;
		this.authors = authors;
		this.read = read;
		this.asin = asin;
		this.dateRead = dateRead;
		this.publishedDate = publishedDate;
	}
	
	public String getReadFormatted() {
		return this.isRead() ? "Yes" : "No";
	}
	
	public String getDateReadFormatted() {
		return this.getDateRead().format(FormatWithLocale.DATE_FORMATTER);
	}
	
	public String getPublishedDateFormatted() {
		return this.getPublishedDate().format(FormatWithLocale.DATE_FORMATTER);
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public LocalDate getDateRead() {
		return dateRead;
	}

	public void setDateRead(LocalDate dateRead) {
		this.dateRead = dateRead;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + (int) (bookId ^ (bookId >>> 32));
		result = prime * result + ((dateRead == null) ? 0 : dateRead.hashCode());
		result = prime * result + ((asin == null) ? 0 : asin.hashCode());
		result = prime * result + ((publishedDate == null) ? 0 : publishedDate.hashCode());
		result = prime * result + (read ? 1231 : 1237);
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (bookId != other.bookId)
			return false;
		if (dateRead == null) {
			if (other.dateRead != null)
				return false;
		} else if (!dateRead.equals(other.dateRead))
			return false;
		if (asin == null) {
			if (other.asin != null)
				return false;
		} else if (!asin.equals(other.asin))
			return false;
		if (publishedDate == null) {
			if (other.publishedDate != null)
				return false;
		} else if (!publishedDate.equals(other.publishedDate))
			return false;
		if (read != other.read)
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", series=" + series + ", authors=" + authors + ", read="
				+ read + ", asin=" + asin + ", dateRead=" + dateRead + ", publishedDate=" + publishedDate + "]";
	}

}
