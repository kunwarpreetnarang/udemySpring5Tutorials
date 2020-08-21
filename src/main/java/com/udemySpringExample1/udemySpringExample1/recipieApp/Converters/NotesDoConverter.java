package com.udemySpringExample1.udemySpringExample1.recipieApp.Converters;

import com.udemySpringExample1.udemySpringExample1.recipieApp.DataObject.NotesDO;
import com.udemySpringExample1.udemySpringExample1.recipieApp.Model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesDoConverter implements Converter<NotesDO, Notes> {

    @Nullable
    @Override
    public Notes convert(NotesDO notesDO) {
        if(notesDO == null)
            return null;
        final Notes notes = new Notes();
        notes.setId(notesDO.getNotesId());
        notes.setRecipieNotes(notesDO.getRecipeNotes());
        return notes;
    }
}
