package model;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
public class Record
{
    public Record() {
    }

    public Record(Long id, String note) {
        this.id = id;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private Long id;
    private String note;
}
