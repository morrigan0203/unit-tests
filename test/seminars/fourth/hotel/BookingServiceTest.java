package seminars.fourth.hotel;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Test
    public void testBookingPositive() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);

        when(hotelService.isRoomAvailable(2)).thenReturn(true);
        boolean bookRoom = bookingService.bookRoom(2);
        verify(hotelService, times(1)).isRoomAvailable(2);
        Assertions.assertThat(bookRoom).isTrue();
    }

    @Test
    public void testBookingNegative() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);

        when(hotelService.isRoomAvailable(3)).thenReturn(false);
        boolean bookRoom = bookingService.bookRoom(3);
        verify(hotelService, times(1)).isRoomAvailable(3);
        Assertions.assertThat(bookRoom).isFalse();
    }
}