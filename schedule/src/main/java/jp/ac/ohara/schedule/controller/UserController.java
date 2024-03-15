package jp.ac.ohara.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.schedule.model.Allschedule;
import jp.ac.ohara.schedule.model.Schedule;
import jp.ac.ohara.schedule.model.User;
import jp.ac.ohara.schedule.service.Allscheduleservice;
import jp.ac.ohara.schedule.service.Scheduleservice;
import jp.ac.ohara.schedule.service.Userservice;

@Controller
public class UserController {
	@Autowired
	private Userservice user;
	@Autowired
	private Scheduleservice schedule;
	@Autowired
	private Allscheduleservice all;
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, Schedule schedule, ModelAndView model) {
		this.schedule.delete(id);
		model.setViewName("delete");
		return model;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		// TODO: model.addAttributeに一覧取得結果を追加
		model.addAttribute("list", this.all.getScheduleList());
		return "top";
	}

	@GetMapping("/user/")
	public ModelAndView user(User usermodel, ModelAndView model) {
		model.addObject("model", usermodel);
		model.setViewName("user");
		return model;
	}
	
	@GetMapping("/schedule/")
	public ModelAndView schedule(Schedule schedulemodel, ModelAndView model) {
		model.addObject("model", schedulemodel);
		model.setViewName("schedule");
		return model;
	}
	
	@GetMapping("/all/")
	public ModelAndView allschedule(Allschedule allmodel, ModelAndView model) {
		model.addObject("model", allmodel);
		model.setViewName("allschedule");
		return model;
	}

	@PostMapping("/user/")
	public String useradd(@Validated @ModelAttribute @NonNull User user, BindingResult valid,
			RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.user.save(user);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";
	}
	
	@PostMapping("/schedule/")
	public String scheduleadd(@Validated @ModelAttribute @NonNull Schedule schedule, BindingResult valid,
			RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.schedule.save(schedule);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";
	}
	
	@PostMapping("/all/")
	public String alladd(@Validated @ModelAttribute @NonNull Allschedule allschedule, BindingResult valid,
			RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.all.save(allschedule);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";
	}
}