package tn.esprit.eventsproject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Participant;
import tn.esprit.eventsproject.repositories.EventRepository;
import tn.esprit.eventsproject.repositories.ParticipantRepository;
import tn.esprit.eventsproject.services.EventServicesImpl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ActiveProfiles("test")
public class EventServicesImplTest {
    @Mock
    private ParticipantRepository participantRepository;

    @Mock
    private EventRepository eventRepository;
    @InjectMocks
    private EventServicesImpl yourServiceClassName;

    @Test
    void testAddParticipant() {
        // Create a sample participant
        Participant participant = new Participant();
        participant.setIdPart(1);
        participant.setNom("John");
        participant.setPrenom("Doe");

        // Mock the repository save method
        when(participantRepository.save(any())).thenReturn(participant);

        // Call the service method
        Participant result = yourServiceClassName.addParticipant(participant);

        // Verify that the repository save method was called with the correct argument
        verify(participantRepository, times(1)).save(participant);

        // Assert the result or perform other relevant assertions
        // Example:
        // assertEquals("John", result.getNom());
    }

    @Test
    void testAddAffectEvenParticipant() {
        // Create a sample event
        Event event = new Event();
        event.setIdEvent(1);
        event.setDescription("Sample Event");
        event.setDateDebut(LocalDate.now());
        event.setDateFin(LocalDate.now().plusDays(1));
        event.setCout(100.0f);

        // Create a sample participant
        Participant participant = new Participant();
        participant.setIdPart(1);
        participant.setNom("John");
        participant.setPrenom("Doe");

        // Mock the repository findById method
        when(participantRepository.findById(anyInt())).thenReturn(java.util.Optional.of(participant));

        // Mock the repository save method
        when(eventRepository.save(any())).thenReturn(event);

        // Call the service method
        Event result = yourServiceClassName.addAffectEvenParticipant(event, 1);

        // Verify that the repository findById method was called with the correct argument
        verify(participantRepository, times(1)).findById(1);

        // Verify that the repository save method was called with the correct argument
        verify(eventRepository, times(1)).save(event);

        // Assert the result or perform other relevant assertions
        // Example:
        // assertEquals("Sample Event", result.getDescription());
    }

    @Test
    void testAddAffectEvenParticipantWithParticipants() {
        // Create a sample event with participants
        Event event = new Event();
        Set<Participant> participants = new HashSet<>();
        Participant participant = new Participant();
        participant.setIdPart(1);
        participants.add(participant);
        event.setParticipants(participants);

        // Mock the repository findById method
        when(participantRepository.findById(anyInt())).thenReturn(java.util.Optional.of(participant));

        // Mock the repository save method
        when(eventRepository.save(any())).thenReturn(event);

        // Call the service method
        Event result = yourServiceClassName.addAffectEvenParticipant(event);

        // Verify that the repository findById method was called with the correct argument
        verify(participantRepository, times(1)).findById(1);

        // Verify that the repository save method was called with the correct argument
        verify(eventRepository, times(1)).save(event);

        // Assert the result or perform other relevant assertions
        // Example:
        // assertEquals(1, result.getParticipants().size());
    }

}
