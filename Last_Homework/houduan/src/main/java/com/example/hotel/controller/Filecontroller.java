package com.example.hotel.controller;


import com.example.hotel.baen.Provincebean;
import com.example.hotel.baen.ResultModel;
import com.example.hotel.baen.ReturnValue;

import com.example.hotel.dao.ProvincebeanMapper;
import com.example.hotel.server.TestServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@Controller
public class Filecontroller
{

    private static final Logger logger = LoggerFactory.getLogger(Filecontroller.class);

    @Autowired
    private TestServiceImp testService;

    @Autowired
    private ResultModel resultModel;


    @Autowired
    private ProvincebeanMapper provincebeanMapper;
    /**
     * 文件上传测试接口
     * @return
     */
    // @PostMapping("/addKnowledge")
    @RequestMapping("/upload")
    @ResponseBody
    public ReturnValue uploadFileTest(@RequestParam("uploadFile") MultipartFile zipFile,@RequestParam String fileName) {
        System.out.println(fileName);

        Provincebean provincebean=new Provincebean();
        provincebean.setUrl(fileName);
        provincebeanMapper.insert(provincebean);

        return testService.uploadFileTest(zipFile , fileName);

    }


    @RequestMapping("/seleall")
    @ResponseBody
    public ResultModel selectBynamepassword()
    {
        List<Provincebean> provincebeans= provincebeanMapper.selectAll();
        if(provincebeans!=null)
        {
            resultModel.setArrayList((ArrayList) provincebeans);
            resultModel.setMsg("成功");
            resultModel.setCode(1);
        }
        else
        {
            resultModel.setMsg("失败");
            resultModel.setCode(-1);
        }
        return resultModel;
    }


}
