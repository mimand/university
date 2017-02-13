package university.com.utility;

import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTaglib extends SimpleTagSupport {

    private String uri;
    private int offset;
    private int count;
    private int max;
    private int page;
    private String previous = "Previous";
    private String next = "Next";

    private Writer getWriter() {
        JspWriter out = getJspContext().getOut();
        return out;
    }

    @Override
    public void doTag() throws JspException {
        Writer out = getWriter();

        try {

            if (offset < max) {
                out.write(constructLink(0, previous, "disabled", true));
            } else {
                out.write(constructLink(0, previous, null, false));
            }
            if (max*3 >count) {
                for (int itr = 0; itr < count; itr += max) {
                    if (offset == itr) {
                        out.write(constructLink((itr / max + 1) - 1 * max, String.valueOf(itr / max + 1), "active", true));
                    } else {
                        out.write(constructLink(itr / max * max, String.valueOf(itr / max + 1), null, false));
                    }
                }
            }
            if (offset + max >= count) {
                out.write(constructLink(count - max, next, "disabled", true));
            } else {
                out.write(constructLink(count - max, next, null, false));
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in Paginator tag", ex);
        }
    }

    private String constructLink(int page, String text, String className, boolean disabled) {
        StringBuilder link = new StringBuilder("<li");
        if (className != null) {
            link.append(" class=\"");
            link.append(className);
            link.append("\"");
        }
        if (disabled) {
            link.append(">").append("<a href=\"#\">" + text + "</a></li>");
        } else {
            link.append(">").append("<a href=\"" + uri + "?offset=" + page + "\">" + text + "</a></li>");
        }
        return link.toString();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
