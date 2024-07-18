package io.spring.gungnir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.gungnir.dto.UserSearchRequest;
import io.spring.gungnir.entity.User;
import io.spring.gungnir.repository.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	// １件検索表示
	public User search(UserSearchRequest userSearchRequest) {
		return userMapper.search(userSearchRequest);
	}

	// 全件表示
	public List<User> searchAll() {
		return userMapper.searchAll();
	}

	// 新規追加処理
	public void create(UserSearchRequest userAdd) {
		userMapper.create(userAdd);
	}

	// 追加情報を画面表示
	public User createCheck(UserSearchRequest userAdd) {
		return userMapper.createCheck(userAdd);
	}

	// 編集対象の検索
	public User editSelect(String id) {
		return userMapper.editSelect(id);
	}

	// 編集実行
	public void update(UserSearchRequest edit) {
		userMapper.edit(edit);
	}

	// レコード情報削除
	public void deleteOne(UserSearchRequest delete) {
		userMapper.deleteOne(delete);
	}

}
