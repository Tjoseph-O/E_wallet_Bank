import model.Account;
import org.junit.jupiter.api.Test;
import repositories.AccountRepository;
import repositories.JoshnickWalletAccountRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountRepositoryTest {
    private final AccountRepository accountRepository = new JoshnickWalletAccountRepository();


    @Test
    public void testSaveAccount(){
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(100_00));
        account.setName("joseph");
        Account savedAccount = accountRepository.save(account);
        assertNotNull(savedAccount);
        assertEquals(8, savedAccount.getId());


    }
}
