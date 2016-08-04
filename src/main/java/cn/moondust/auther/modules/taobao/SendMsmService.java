package cn.moondust.auther.modules.taobao;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.stereotype.Service;

/**
 * Created by j0 on 2016/8/4.
 */
@Service
public class SendMsmService {

    private String url="http://gw.api.taobao.com/router/rest";
    private String appkey="23317414";
    private String secret="4cf3a1bc2c5174753a8bf28ddf095010";


    public boolean sendMsmCode(String phone, String code) {
        boolean res = false;
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName("阿里大于");
        req.setSmsParamString("{\"code\":\"1234\"}");
        req.setRecNum(phone);
        req.setSmsTemplateCode("SMS_585014");
        try {
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
            res = rsp.isSuccess();
        } catch (ApiException e) {
            res = false;
        }
        return res;
    }


}
