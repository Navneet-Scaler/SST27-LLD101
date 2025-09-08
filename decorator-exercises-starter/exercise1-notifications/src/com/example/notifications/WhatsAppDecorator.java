package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String whatsappId;

    public WhatsAppDecorator(Notifier wrapped, String whatsappId) {
        super(wrapped);
        this.whatsappId = whatsappId;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        sendWhatsApp(text);
    }

    private void sendWhatsApp(String text) {
        System.out.println("[WHATSAPP -> " + whatsappId + "]: " + text);
    }
}
