package com.magas;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
	
	private Long id;
	private String text;
	private Message nextMessage;

	@Id @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "next_message_id")
	public Message getNextMessage() {
		return nextMessage;
	}

	public void setNextMessage(Message nextMessage) {
		this.nextMessage = nextMessage;
	}
}
