import org.fisco.bcos.channel.client.Service;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.precompile.config.SystemConfigService;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;

public class Test01 {
    public static void main(String[] args) throws Exception {
        //读取配置文件，SDK与区块链节点建立连接
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service service = context.getBean(Service.class);
        System.out.println(service);
        service.run();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
//        ChannelEthereumService channelEthereumService = new ChannelEthereumService();
//        channelEthereumService.setChannelService(service);
//        //获取Web3j对象
//        Web3j web3j = Web3j.build(channelEthereumService, service.getGroupId());
//        //通过Web3j对象调用API接口getBlockNumber
//        BigInteger blockNumber = web3j.getBlockNumber().send().getBlockNumber();
//        System.out.println(blockNumber);
//        String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
//        //指定外部账户私钥，用于交易签名
//        Credentials credentials = GenCredential.create(privateKey);
//        //获取SystemConfigService对象
//        SystemConfigService systemConfigService = new SystemConfigService(web3j, credentials);
//        //通过SystemConfigService对象调用API接口setValueByKey
//        String result = systemConfigService.setValueByKey("tx_count_limit", "2000");
//        //通过Web3j对象调用API接口getSystemConfigByKey
//        String value = web3j.getSystemConfigByKey("tx_count_limit").send().getSystemConfigByKey();
//        System.out.println(value);
    }
}
