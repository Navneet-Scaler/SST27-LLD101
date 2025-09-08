package com.example.notifications;

/**
 * Starter demo that uses Email notifier and decorators.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline
        base.notify("Baseline email only.");

        // a) Email + SMS
        Notifier emailSms = new SmsDecorator(base, "+91-99999-11111");
        emailSms.notify("Build green ✅");

        // b) Email + WhatsApp
        Notifier emailWhatsApp = new WhatsAppDecorator(base, "user_wa");
        emailWhatsApp.notify("Meeting at 5 PM");

        // c) Email + Slack
        Notifier emailSlack = new SlackDecorator(base, "general");
        emailSlack.notify("Server restarted");

        // d) Email + WhatsApp + Slack
        Notifier emailWhatsAppSlack = new SlackDecorator(
                new WhatsAppDecorator(base, "user_wa"),
                "deployments"
        );
        emailWhatsAppSlack.notify("Deployment completed 🚀");
    }
}
