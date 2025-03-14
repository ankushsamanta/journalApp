package com.ankush.journalApp.service;

import java.util.stream.Stream;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.ankush.journalApp.entity.User;


public class UserArgumentsProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
			Arguments.of(User.builder().userName("talib").password("talib123").build()),
			Arguments.of(User.builder().userName("suraj").password("").build())
			);
	}

}
