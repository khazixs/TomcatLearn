import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class test01 {
    public static void main(String[] args) throws Exception {
        Map<String, Object> map1 = EcDsaCode.initKey();
        KeyPair keyPair1 = EcDsaCode.generateKey((BigInteger) map1.get("Q"), (BigInteger) map1.get("A"), (BigInteger) map1.get("B"), (BigInteger) map1.get("N"), (Integer) map1.get("H"), (BigInteger) map1.get("X"), (BigInteger) map1.get("Y"), (BigInteger) map1.get("PUBKEY_X"), (BigInteger) map1.get("PUBKEY_Y"), (BigInteger) map1.get("D"));
        System.out.println("1的公钥："+keyPair1.getPublic());
        System.out.println("1的私钥："+keyPair1.getPrivate());
        String time = new Date().toString();
        byte[] bytesT = time.getBytes();
        byte[] bytes =EcDsaCode.sign(bytesT,keyPair1.getPrivate());
        System.out.println(Arrays.toString(bytes));
        boolean flag = EcDsaCode.verify(bytesT,keyPair1.getPublic(),bytes);
        System.out.println(flag);
    }

}
