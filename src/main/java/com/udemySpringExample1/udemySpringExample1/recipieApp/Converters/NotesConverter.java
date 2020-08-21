package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.NotesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Notes;
import org.springframework.core.convert.converter.Converter;

public class NotesConverter implements Converter<Notes, NotesDO> {
    @Override
    public NotesDO convert(Notes notes) {
        if(notes == null)
            return null;
        final NotesDO notesDO = new NotesDO();
        notesDO.setNotesId(notes.getId());
        notesDO.setRecipeNotes(notes.getRecipieNotes());
        return notesDO;
    }
}
