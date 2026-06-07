package com.example.ticketline.Models.Enum;

public enum TicketStatus {
    RESERVED,   // Enquanto aguarda a confirmação do pagamento
    PAID,       // Compra concluída, bilhete ativo e válido
    CANCELLED,  // Se o pagamento falhar ou o cliente pedir reembolso
    USED        // Quando o QR Code for lido na entrada do evento
}
