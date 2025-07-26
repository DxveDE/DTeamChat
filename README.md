# 📦 DTeamChat

Simply chat plugin to send messages to your team members via command.

> Developed for **Minecraft 1.21** – fully configurable and permission-based!

---

## ✨ Features

- ✅ **Easy Chat**: Write messages with `/teamchat`
- 🛠️ **Fully configurable**:  
  - Messages
  - Permissions
- 🔄 **Update Checker**: Informs operators when a new version is available (on server start and join)  

---

## 📥 Installation

1. Download the latest version from the [Releases page](https://github.com/DxveDE/DTeamChat/releases)  
2. Drop the plugin `.jar` into your `/plugins` folder  
3. Start your server  
4. Edit the `config.yml` as needed  

**Tested with:**  
🧱 **Minecraft 1.21**  
🪵 Compatible with **Spigot** and **Paper**  

---

## ⚙️ Configuration example (insert in your README without code block)

<details>
  <summary>Click to view the default <code>config.yml</code></summary>

```
#
#  ██████████   ███████████                                      █████████  █████                 █████
# ░░███░░░░███ ░█░░░███░░░█                                     ███░░░░░███░░███                 ░░███
#  ░███   ░░███░   ░███  ░   ██████   ██████   █████████████   ███     ░░░  ░███████    ██████   ███████
#  ░███    ░███    ░███     ███░░███ ░░░░░███ ░░███░░███░░███ ░███          ░███░░███  ░░░░░███ ░░░███░
#  ░███    ░███    ░███    ░███████   ███████  ░███ ░███ ░███ ░███          ░███ ░███   ███████   ░███
#  ░███    ███     ░███    ░███░░░   ███░░███  ░███ ░███ ░███ ░░███     ███ ░███ ░███  ███░░███   ░███ ███
#  ██████████      █████   ░░██████ ░░████████ █████░███ █████ ░░█████████  ████ █████░░████████  ░░█████
# ░░░░░░░░░░      ░░░░░     ░░░░░░   ░░░░░░░░ ░░░░░ ░░░ ░░░░░   ░░░░░░░░░  ░░░░ ░░░░░  ░░░░░░░░    ░░░░░
#

# DTeamChat v1.0.0 by DxveDE
# https://discord.gg/dxve


# The prefix for all messages (can be used with %prefix% in the messages, not for command-only-players)
prefix: "&4DTeamChat &8┃&7"

settings:
    # Checks automatically for updates
    # If an update was found, you get a message on server join (you need operator to get the message)
    update-checker: true

    # Permission to use and see the team chat
    permission: "dteamchat.use"

    # Chat colors in team chat?
    color-codes: true

messages:
    no-permissions: "%prefix% &cYou do not have sufficient permissions for this."
    command-only-players: "This command is only for players."
    teamchat-message: "%prefix% &f%playername%&8: &7&o%message%"
    syntax: "%prefix% &cUsage of command: &7/teamchat <message>"
```
</details>

---

## 🧾 Commands

| Command       | Description                    | Permission       |  
|---------------|--------------------------------|------------------|  
| /teamchat     | Write messages into the chat   | dteamchat.use   |  

---

## 🔐 Permissions

| Permission                  | Description                                      |  
|-----------------------------|------------------------------------------------|  
| dteamchat.use               | Allows access to the `/teamchat` command      |  

---

## 📸 Screenshots & Videos

> 📹 Screenshots and a short demo video will be available soon:  

![Demo](https://cdn.upload-host.de/1/26d08f-2bd602.png)

---

## 🆘 Support & Feedback

Need help or want to report a bug?  

- 📧 Email: kontakt@dxve.de  
- 💬 Discord: https://discord.gg/dxve  
- 🐞 GitHub Issues: https://github.com/DxveDE/DTeamChat/issues  

---

## 🔓 License

This project is licensed under the **MIT License**.  
You’re free to use, modify, and redistribute the code as long as you include credit to the original author.  

> ⚠️ Provided *as-is*, without warranty.  

See LICENSE file for details.  
