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
            this.sender ="ismaellatin7@gmail.com";
            this.password = "Scouts72.";
            this.receiver = "bryansabillongp@gmail.com";
        }
}
