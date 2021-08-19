package projectSolid.Service;

import lombok.Getter;
import lombok.Setter;

public class EmailData {

        @Getter
        @Setter
        private String sender;
        @Getter @Setter
        private String password;
        @Getter @Setter
        private String receiver;

        public EmailData(){
            this.sender ="emre21011992@gmail.com";
            this.password = "Carlos@92";
            this.receiver = "i.latinbrenes11@gmail.com";
        }
}
