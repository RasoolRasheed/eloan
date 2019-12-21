/*
 * package com.eloan2.controller;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.json.JSONObject; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * import com.eloan2.domain.LStatus; import com.eloan2.domain.SecurityTypes;
 * import com.eloan2.service.LStatusService; import
 * com.eloan2.service.RSheduleService;
 * 
 * 
 * @Controller public class RSheduleController {
 * 
 * @Autowired private RSheduleService sheduleService;
 * 
 * public RSheduleService getSheduleService() { return sheduleService; } public
 * void setSheduleService(RSheduleService sheduleService) { this.sheduleService
 * = sheduleService; }
 * 
 * @RequestMapping(value="/createLStatus.do", method = RequestMethod.POST)
 * 
 * @ResponseBody public String createLStatus(HttpServletRequest req,
 * 
 * @RequestParam String lsc,
 * 
 * @RequestParam String des, HttpServletResponse res ) {
 * 
 * JSONObject jo = new JSONObject(); LStatus lsts = new LStatus();
 * lsts.setLsc(lsc); lsts.setDes(des);
 * 
 * if (lsc.trim().equals("") || lsc.equals(null)) { jo.put("error1",
 * "Please fill in the required fields"); jo.put("error2",
 * "Please fill in the required fields"); return jo.toString();
 * 
 * } else if (des.trim().equals("") || des.equals(null)) { jo.put("error1", "");
 * jo.put("error2", "Please fill in the required fields"); return jo.toString();
 * 
 * } else { //getSheduleService().saveSchedule(sche); jo.put("success",
 * "Loan Status created Successfull"); // model.addAttribute("success",
 * "User created Successfull"); return jo.toString(); }
 * 
 * }
 * 
 * @RequestMapping(path = "/updateLoanStatus.do", method = RequestMethod.GET)
 * 
 * @ResponseBody public String updateLoanStatus(HttpServletRequest
 * req, @RequestParam int sno, @RequestParam String lsc,
 * 
 * @RequestParam String des, HttpServletResponse res, Model model) {
 * System.out.println("sd"); JSONObject stdo = new JSONObject(); LStatus st =
 * getSheduleService().getLStatusId(sno); System.out.println(st.getSno());
 * 
 * st.setDes(des); st.setLsc(lsc);
 * 
 * // model.addAttribute("user", new Users()); // model.addAttribute("viewUser",
 * this.userService.listUsers()); getSheduleService().updateLStatus(st);
 * stdo.put("success", "Updated successfull"); // stdo.put("viewUser",
 * this.userService.listUsers());
 * 
 * return stdo.toString(); }
 * 
 * @RequestMapping(value = "/removeLStatus.do", method = RequestMethod.GET)
 * 
 * @ResponseBody public String removeLStatus(HttpServletRequest
 * req,@RequestParam int sno,HttpServletResponse res) {
 * 
 * //LStatus st = getLsService().getLStatusId(sno); JSONObject stdo = new
 * JSONObject(); // if(st.getId() == 0) { // stdo.put("error3",
 * "Failed to delete, already deleted"); // }else {
 * //System.out.println(st.getSno()); //getLsService().removeLStatus(sno); // }
 * 
 * 
 * stdo.put("success", "Deleted successfull"); // return
 * "redirect:/viewLStatus.do"; return stdo.toString(); } }
 */