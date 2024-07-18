package io.spring.gungnir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.spring.gungnir.dto.UserSearchRequest;
import io.spring.gungnir.entity.User;
import io.spring.gungnir.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/user")
	public String display() {
		return "top";
	}

	// 1件検索するためのフォームを表示
	@GetMapping(value = "user/search")
	public String displaySearch() {
		return "player_search";
	}

	// 1件検索の実行
	@RequestMapping(value = "/user/id_search", method = RequestMethod.POST)
	public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
		User user = userService.search(userSearchRequest);
		model.addAttribute("user_info", user);
		return "player_search";
	}


	// 全件表示
    @PostMapping(value = "/user/list")
    public String getUserList(Model model) {
        List <User> list = userService.searchAll();
        model.addAttribute("users_info", list);
        return "list";
    }

    // 新規プレイヤー登録画面を表示
    @PostMapping(value = "/user/add")
    public String displayAdd() {
        return "add_player";
    }

    // 登録の実行
    @RequestMapping(value = "user/add_comp", method = RequestMethod.POST )

  	public String create(@ModelAttribute UserSearchRequest userAdd, Model model) {

    	userService.create(userAdd);
          User user = userService.createCheck(userAdd);
          model.addAttribute("user_add", user);
          return "add_comp";
      }

    // 編集画面へ遷移
    @PutMapping(value = "/user/conf/id={id}")
    public String editSelect(@PathVariable("id")String id ,Model model){

        User user = userService.editSelect(id);
        model.addAttribute("user_select",user);
        return "conf_player";
    }

    // 編集の実行
    @RequestMapping(value = "/user/edit/id={id}", method = RequestMethod.POST)
    public String update(@ModelAttribute UserSearchRequest edit) {
        userService.update(edit);
        return "edit";
    }

    // 削除の実行
    @DeleteMapping(value = "user/delete/id={id}")
    public String displayDelete(@ModelAttribute UserSearchRequest delete) {
        userService.deleteOne(delete);
        return "delete";
    }

}
