package org.sahil.msbroker.web;

import org.sahil.msbroker.config.RabbitMQSender;
import org.sahil.msbroker.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mq/")
public class RabbitMQWebController {

    @Autowired
    private RabbitMQSender rabbitMQSender;


    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName,
            @RequestParam("empId") String empId) {

        final Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);

        rabbitMQSender.send(emp);
        return "Message sent to the Messaging queue Successfully";
    }

}
