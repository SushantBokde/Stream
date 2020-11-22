package com.reply.stream;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	public void throwMeError() throws IOException {
		throw new IOException("Test exception");
	}
}
